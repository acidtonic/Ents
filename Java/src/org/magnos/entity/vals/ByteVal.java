/* 
 * NOTICE OF LICENSE
 * 
 * This source file is subject to the Open Software License (OSL 3.0) that is 
 * bundled with this package in the file LICENSE.txt. It is also available 
 * through the world-wide-web at http://opensource.org/licenses/osl-3.0.php
 * If you did not receive a copy of the license and are unable to obtain it 
 * through the world-wide-web, please send an email to magnos.software@gmail.com 
 * so we can send you a copy immediately. If you use any of this software please
 * notify me via our website or email, your feedback is much appreciated. 
 * 
 * @copyright   Copyright (c) 2011 Magnos Software (http://www.magnos.org)
 * @license     http://opensource.org/licenses/osl-3.0.php
 * 				Open Software License (OSL 3.0)
 */

package org.magnos.entity.vals;

import org.magnos.entity.ComponentValueFactory;


/**
 * A mutable wrapper around a byte that should replace the usage of the
 * {@link java.lang.Byte}. Using {@link java.lang.Byte} should be avoided, the
 * "invisible" autoboxing and unboxing can cause a significant performance hit
 * in games when used inappropriately.
 * 
 * @author Philip Diffenderfer
 * 
 */
public class ByteVal implements ComponentValueFactory<ByteVal>
{

    public byte v;

    public ByteVal()
    {
    }

    public ByteVal( byte v )
    {
        this.v = v;
    }

    public ByteVal( ByteVal iv )
    {
        this.v = iv.v;
    }

    @Override
    public ByteVal create()
    {
        return new ByteVal( v );
    }

    @Override
    public ByteVal clone( ByteVal value )
    {
        return new ByteVal( value );
    }

    @Override
    public ByteVal copy( ByteVal from, ByteVal to )
    {
        to.v = from.v;

        return to;
    }

    @Override
    public int hashCode()
    {
        return v;
    }

    @Override
    public boolean equals( Object obj )
    {
        return (obj instanceof ByteVal) && ((ByteVal)obj).v == v;
    }

    @Override
    public String toString()
    {
        return String.valueOf( v );
    }

}
