package com.modinfodesigns.network.io;

import java.io.InputStream;

// Deprecate - replace wigh TikaContentFilter

public class MSWordXContentFilter implements IContentStreamFilter
{
  private String name;
    
  @Override
  public void setName(String name)
  {
    this.name = name;
  }

  @Override
  public String getName()
  {
    return this.name;
  }

  @Override
  public String getContentType()
  {
    return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
  }

  @Override
  public InputStream filterInputStream( InputStream source )
  {
    return null;
  }

}
