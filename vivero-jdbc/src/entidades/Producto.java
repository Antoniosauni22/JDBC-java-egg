package entidades;

public class Producto {

    private  int productoId;
    private  String codigoProducto;
    private  String nombre;
    private  int idGama;
    private  String dimesiones;
    private  String proveedor;
    private  String descripcion;
    private  short  cantidadEnStock;
    private  double precioVenta;
    private  double precioProveedor;

    public Producto(int productoId, String codigoProducto, String nombre, int idGama, String dimesiones, String proveedor, short cantidadEnStock, String descripcion, double precioVenta, double precioProveedor) {
        this.productoId = productoId;
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.idGama = idGama;
        this.dimesiones = dimesiones;
        this.proveedor = proveedor;
        this.cantidadEnStock = cantidadEnStock;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.precioProveedor = precioProveedor;
    }

    public Producto() {
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdGama() {
        return idGama;
    }

    public void setIdGama(int idGama) {
        this.idGama = idGama;
    }

    public String getDimesiones() {
        return dimesiones;
    }

    public void setDimesiones(String dimesiones) {
        this.dimesiones = dimesiones;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(short cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(double precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "productoId=" + productoId +
                ", codigoProducto='" + codigoProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", idGama=" + idGama +
                ", dimesiones='" + dimesiones + '\'' +
                ", proveedor='" + proveedor + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidadEnStock=" + cantidadEnStock +
                ", precioVenta=" + precioVenta +
                ", precioProveedor=" + precioProveedor +
                '}';
    }




}
