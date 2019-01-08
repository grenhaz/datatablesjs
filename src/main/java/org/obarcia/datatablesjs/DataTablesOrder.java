package org.obarcia.datatablesjs;

/**
 * Datatables: Order.
 * 
 * @author obarcia
 */
public class DataTablesOrder
{
    public static int ORDER_ASC = 0;
    public static int ORDER_DESC = 1;
    
    /**
     * Column name.
     */
    private String data;
    /**
     * Order direction: ASC / DESC.
     */
    private Integer dir;
    
    // ******************************************
    // GETTER & SETTER
    // ******************************************
    public String getData()
    {
        return data;
    }
    public void setData(String value)
    {
        data = value;
    }
    public Integer getDir()
    {
        return dir;
    }
    public void setDir(Integer value)
    {
        dir = value;
    }
}