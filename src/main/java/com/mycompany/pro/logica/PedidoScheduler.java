
package com.mycompany.pro.logica;

import com.mycompany.pro.persistencia.ControladoraPersistencia;
import java.time.LocalDate;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoScheduler {
    private final ControladoraPersistencia controlPersis;
    private final Timer timer = new Timer();

    public PedidoScheduler(ControladoraPersistencia controlPersis) {
        this.controlPersis = controlPersis;
        iniciarScheduler();
    }

    private void iniciarScheduler() {
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                try {
                    actualizarEstadosPedido();
                } catch (Exception ex) {
                    Logger.getLogger(PedidoScheduler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        // Programar la tarea para que se ejecute cada un dia
        timer.scheduleAtFixedRate(tarea, 0, 86400000);
    }

    private void actualizarEstadosPedido() throws Exception {
        List<Pedido> pedidos = controlPersis.traerPedidos();
        for (Pedido pedido : pedidos) {
            LocalDate fechaPedido = pedido.getFechaPedido();
            int tiempoEnvio = pedido.getRuta().getTiempoEnvio();
            // Convertir tiempo de envío a días
            long diasEnvio = tiempoEnvio; 
            // Calcular la fecha límite para el cambio de estado
            LocalDate fechaLimite = fechaPedido.plusDays(diasEnvio);

            // Obtener la fecha actual
            LocalDate fechaActual = LocalDate.now();
            if (fechaActual.isAfter(fechaLimite)&& pedido.getEstado() == Pedido.EstadoPedido.ENVIADO) {
                pedido.setEstado(Pedido.EstadoPedido.FINALIZADO);
                controlPersis.editarPedido(pedido);
            }
        }
    }
}
