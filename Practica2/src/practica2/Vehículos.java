package practica2;

import java.io.Serializable;

public class Vehículos implements Serializable {
        public int id;
        public String fechaHoraInicio;
        public String fechaHoraFin;
        public int distanciaTotalRecorrida;
        public String vehiculo;
        public double gasolinaUtilizada;

        public Vehículos(int id, String fechaHoraInicio, String fechaHoraFin, int distanciaTotalRecorrida, String vehiculo, double gasolinaUtilizada) {
            this.id = id;
            this.fechaHoraInicio = fechaHoraInicio;
            this.fechaHoraFin = fechaHoraFin;
            this.distanciaTotalRecorrida = distanciaTotalRecorrida;
            this.vehiculo = vehiculo;
            this.gasolinaUtilizada = gasolinaUtilizada;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFechaHoraInicio() {
            return fechaHoraInicio;
        }

        public void setFechaHoraInicio(String fechaHoraInicio) {
            this.fechaHoraInicio = fechaHoraInicio;
        }

        public String getFechaHoraFin() {
            return fechaHoraFin;
        }

        public void setFechaHoraFin(String fechaHoraFin) {
            this.fechaHoraFin = fechaHoraFin;
        }

        public int getDistanciaTotalRecorrida() {
            return distanciaTotalRecorrida;
        }

        public void setDistanciaTotalRecorrida(int distanciaTotalRecorrida) {
            this.distanciaTotalRecorrida = distanciaTotalRecorrida;
        }

        public String getVehiculo() {
            return vehiculo;
        }

        public void setVehiculo(String vehiculo) {
            this.vehiculo = vehiculo;
        }

        public double getGasolinaUtilizada() {
            return gasolinaUtilizada;
        }

        public void setGasolinaUtilizada(double gasolinaUtilizada) {
            this.gasolinaUtilizada = gasolinaUtilizada;
        }
        
    }
