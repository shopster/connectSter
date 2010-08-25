package connectster.adapter.shopify.entity;

import java.io.Serializable;

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
 *
 * Object form of the following shopify XML snippet, see ShopifyEntityHelper for aliases.
 *
 * <address1>Chestnut Street 92</address1>
 * <address2></address2>
 * <city>Louisville</city>
 * <company nil="true"></company>
 * <country>United States</country>
 *  <first-name>Bob</first-name>
 *  <last-name>Norman</last-name>
 *  <phone>555-625-1199</phone>
 *  <province>Kentucky</province>
 *  <zip>40202</zip>
 *  <name>Bob Norman</name>
 *  <country-code>US</country-code>
 *  <province-code>KY</province-code>
 */
public class ShopifyAddress
implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String address1;
    private String address2;
    private String city;
    private String company;
    private String country;
    private String firstName;
    private String lastName;
    private String phone;
    private String province;
    private String zip;
    private String name;
    private String countryCode;
    private String provinceCode;

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getAddress1()
    {
        return address1;
    }

    public void setAddress1( String address1 )
    {
        this.address1 = address1;
    }

    public String getAddress2()
    {
        return address2;
    }

    public void setAddress2( String address2 )
    {
        this.address2 = address2;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity( String city )
    {
        this.city = city;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany( String company )
    {
        this.company = company;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry( String country )
    {
        this.country = country;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone( String phone )
    {
        this.phone = phone;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince( String province )
    {
        this.province = province;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip( String zip )
    {
        this.zip = zip;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode( String countryCode )
    {
        this.countryCode = countryCode;
    }

    public String getProvinceCode()
    {
        return provinceCode;
    }

    public void setProvinceCode( String provinceCode )
    {
        this.provinceCode = provinceCode;
    }
}
