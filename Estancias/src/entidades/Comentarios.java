package entidades;

public class Comentarios {

   private int comentarioId;
   private int casaId;
   private String comentario;

    public Comentarios(int comentarioId, int casaId, String comentario) {
        this.comentarioId = comentarioId;
        this.casaId = casaId;
        this.comentario = comentario;
    }

    public Comentarios() {
    }

    public int getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(int comentarioId) {
        this.comentarioId = comentarioId;
    }

    public int getCasaId() {
        return casaId;
    }

    public void setCasaId(int casaId) {
        this.casaId = casaId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentarios{" +
                "comentarioId=" + comentarioId +
                ", casaId=" + casaId +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
