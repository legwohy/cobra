package com.cobra.pojo;

/**
 * @className ${ClassName}
 * @auther: leigang
 * @date: 2018/11/20 14:08
 * @description:
 */
public class User2
{
    private String id;
    private String name;
    private String address;

    public User2()
    {
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "User2{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", address='" + address + '\'' +
                        '}';
    }
}
