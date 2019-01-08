package org.obarcia.datatablesjs;

/**
 * Datables: Column.
 * 
 * @author obarcia
 */
public class DataTablesColumn
{
    /**
     * Column name.
     */
    private String data;
    /**
     * Alternative column name.
     */
    private String name;
    /**
     * Searchable or not.
     */
    private Boolean searchable;
    /**
     * Orderable or not.
     */
    private Boolean orderable;
    /**
     * Search string.
     */
    private String search;
    
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
    public String getName()
    {
        return name;
    }
    public void setName(String value)
    {
        name = value;
    }
    public Boolean getSearchable()
    {
        return searchable;
    }
    public void setSearchable(Boolean value)
    {
        searchable = value;
    }
    public Boolean getOrderable()
    {
        return orderable;
    }
    public void setOrderable(Boolean value)
    {
        orderable = value;
    }
    public String getSearch()
    {
        return search;
    }
    public void setSearch(String value)
    {
        search = value;
    }
}