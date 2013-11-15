package asteroids;

import java.awt.Color;

import org.magnos.entity.ComponentValueFactory;

/**
 * A {@link ComponentValueFactory} for {@link Color}.
 * 
 * @author Philip Diffenderfer
 *
 */
public class ColorValueFactory implements ComponentValueFactory<Color>
{

    @Override
    public Color create()
    {
        return Color.white;
    }

    @Override
    public Color clone( Color value )
    {
        return new Color( value.getRed(), value.getGreen(), value.getBlue(), value.getAlpha() );
    }

    @Override
    public Color copy( Color from, Color to )
    {
        return clone( from );
    }

}