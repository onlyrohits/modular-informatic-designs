package com.modinfodesigns.property.compare;

import com.modinfodesigns.property.IProperty;
import com.modinfodesigns.property.IPropertyHolder;
import com.modinfodesigns.security.IUserCredentials;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Matches an IPropertyHolder if the object contains a property with a specified
 * name and that property matches a delegate IPropertyMatcher
 * 
 * @author Ted Sullivan
 */

public class PropertyValueMatcher implements IPropertyHolderMatcher
{
  private transient static final Logger LOG = LoggerFactory.getLogger( PropertyValueMatcher.class );

  private String propertyName;
  private IPropertyMatcher compareMatcher;
	 
  public void setPropertyName( String propertyName )
  {
    LOG.debug( "setPropertyName " + propertyName );
    this.propertyName = propertyName;
  }
	
  public void setPropertyMatcher( IPropertyMatcher matcher )
  {
    LOG.debug( "setPropertyMatcher( ) " + matcher );
    this.compareMatcher = matcher;
  }

  @Override
  public boolean equals( IUserCredentials user, IProperty property )
  {
    if (property == null ) return false;
    LOG.debug( "equals " + property.getValue( ) );
		
    return compareMatcher.equals(  user, property );
  }

  @Override
  public boolean equals( IUserCredentials user, IPropertyHolder propHolder )
  {
    LOG.debug( "equals " + propHolder.getValue( ) );
    IProperty prop = propHolder.getProperty( propertyName );
		
    LOG.debug( "Comparing property: " + propertyName + " = " + prop.getValue( ) + " with " + compareMatcher );
    boolean matches = (prop != null && compareMatcher.equals( user, prop ));
    LOG.debug( "Matches = " + matches );
		
    return matches;
  }
	
}