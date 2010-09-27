package connectster.adapter.shopify.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Copyright 2010 Shopster E-Commerce Inc.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class ShopifyProduct
implements Serializable
{
	private static final long serialVersionUID = 1L;

    private String bodyHtml;
    private Date createdAt;
    private String handle;
    private String id;
    private String productType;
    private Date publishedAt;
    private String templateSuffix;
    private String title;
    private Date updatedAt;
    private String vendor;
    private String tags;
    private String body;
    private List<ShopifyVariant> variants;
    private List<ShopifyImage> images;
    private List<ShopifyOption> options;

    public String getBodyHtml()
    {
        return bodyHtml;
    }

    public void setBodyHtml( String bodyHtml )
    {
        this.bodyHtml = bodyHtml;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt( Date createdAt )
    {
        this.createdAt = createdAt;
    }

    public String getHandle()
    {
        return handle;
    }

    public void setHandle( String handle )
    {
        this.handle = handle;
    }

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    public String getProductType()
    {
        return productType;
    }

    public void setProductType( String productType )
    {
        this.productType = productType;
        if( productType == null || productType.isEmpty( ) )
        {
            this.productType = "General";
        }
    }

    public Date getPublishedAt()
    {
        return publishedAt;
    }

    public void setPublishedAt( Date publishedAt )
    {
        this.publishedAt = publishedAt;
    }

    public String getTemplateSuffix()
    {
        return templateSuffix;
    }

    public void setTemplateSuffix( String templateSuffix )
    {
        this.templateSuffix = templateSuffix;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt( Date updatedAt )
    {
        this.updatedAt = updatedAt;
    }

    public String getVendor()
    {
        return vendor;
    }

    public void setVendor( String vendor )
    {
        this.vendor = vendor;
    }

    public String getTags()
    {
        return tags;
    }

    public void setTags( String tags )
    {
        this.tags = tags;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody( String body )
    {
        this.body = body;
    }

    public List<ShopifyVariant> getVariants()
    {
        return variants;
    }

    public void setVariants( List<ShopifyVariant> variants )
    {
        this.variants = variants;
    }

    public List<ShopifyImage> getImages()
    {
        return images;
    }

    public void setImages( List<ShopifyImage> images )
    {
        this.images = images;
    }

    public List<ShopifyOption> getOptions()
    {
        return options;
    }

    public void setOptions( List<ShopifyOption> options )
    {
        this.options = options;
    }
}
