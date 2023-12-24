package jaboc_Biblioteca.glasspanepopup;

import java.awt.Color;
import java.awt.Component;


public interface Option {

    public String getLayout(Component parent, float animate);

    public boolean useSnapshot();
    
    public boolean closeWhenPressedEsc();

    public boolean closeWhenClickOutside();

    public boolean blockBackground();

    public Color background();

    public float opacity();

    public int duration();

    public float getAnimate();

    void setAnimate(float animate);
}
