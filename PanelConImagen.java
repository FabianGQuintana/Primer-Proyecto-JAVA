import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

// Clase interna para personalizar un panel con una imagen de fondo
class PanelConImagen extends JPanel {
    private Image imagen;

    public PanelConImagen(ImageIcon imagenIcono) {
        this.imagen = imagenIcono.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            // Dibujar la imagen en el fondo
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
    



