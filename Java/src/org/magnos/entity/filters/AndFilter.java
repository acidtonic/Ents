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

package org.magnos.entity.filters;

import org.magnos.entity.Entity;
import org.magnos.entity.EntityChain;
import org.magnos.entity.EntityFilter;
import org.magnos.entity.EntityList;


/**
 * A filter that combines two filters with AND logic.
 * 
 * @author Philip Diffenderfer
 * @see EntityFilter
 * 
 */
public class AndFilter extends EntityFilter
{

   protected EntityFilter first;
   protected EntityFilter second;

   /**
    * Resets the AndFilter specifying the root entity and the filters to combine.
    * 
    * @param root
    *        The root entity to filter. This entity is typically an
    *        {@link EntityChain} or {@link EntityList} which both can contain
    *        any number of entities.
    * @param first
    *        The first filter to check for valid entities.
    * @param second
    *        The second filter to check for valid entities.
    * @return The {@link Iterable} filtered by both filters.
    */
   public EntityFilter reset( Entity root, EntityFilter first, EntityFilter second )
   {
      return reset( first, second ).reset( root );
   }

   /**
    * Resets the AndFilter specifying the filters to combine.
    * 
    * @param first
    *        The first filter to check for valid entities.
    * @param second
    *        The second filter to check for valid entities.
    * @return The {@link Iterable} filtered by both filters.
    */
   public EntityFilter reset( EntityFilter first, EntityFilter second )
   {
      this.first = first;
      this.second = second;

      return this;
   }

   
   @Override
   public boolean isValid( Entity e )
   {
      return first.isValid( e ) && second.isValid( e );
   }

}