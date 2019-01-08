package org.obarcia.datatablesjs;

import java.util.List;

/**
 * DataTables: Response.
 * 
 * @author obarcia
 */
public class DataTablesResponse<T>
{
    /**
     * draw: It must match with the request draw.
     */
    private int draw = 1;
    /**
     * Total of records.
     */
    private int recordsTotal = 0;
    /**
     * Total of records after applied filters.
     */
    private int recordsFiltered = 0;
    /**
     * List of records.
     */
    private List<T> data;
    
    // ******************************************
    // GETTER & SETTER
    // ******************************************
    public int getDraw()
    {
        return draw;
    }
    public void setDraw(int value)
    {
        draw = value;
    }
    public int getRecordsTotal()
    {
        return recordsTotal;
    }
    public void setRecordsTotal(int value)
    {
        recordsTotal = value;
    }
    public int getRecordsFiltered()
    {
        return recordsFiltered;
    }
    public void setRecordsFiltered(int value)
    {
        recordsFiltered = value;
    }
    public List<T> getData()
    {
        return data;
    }
    public void setData(List<T> value)
    {
        data = value;
    }
}