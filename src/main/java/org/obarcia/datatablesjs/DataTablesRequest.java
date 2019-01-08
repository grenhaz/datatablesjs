package org.obarcia.datatablesjs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 * DataTables: Request.
 * 
 * @author obarcia
 */
public class DataTablesRequest
{
    /**
     * draw from request.
     */
    private Integer draw = 1;
    /**
     * Offset of records.
     */
    private Integer start = 0;
    /**
     * Total of records.
     */
    private Integer length = 0;
    /**
     * Generic search.
     */
    private String search = null;
    /**
     * List of columns indexes by its number.
     */
    private final HashMap<Integer, DataTablesColumn> columnsIndex = new HashMap<>();
    /**
     * List of columns indexes by its name.
     */
    private final HashMap<String, DataTablesColumn> columns = new HashMap<>();
    /**
     * List of ordenations.
     */
    private final List<DataTablesOrder> order = new ArrayList<>();
    
    /**
     * Contructor.
     * @param request Request instance.
     */
    public DataTablesRequest(HttpServletRequest request)
    {
        setupRequest(request);
    }
    /**
     * Proccess a request.
     * @param request Request instance.
     */
    private void setupRequest(HttpServletRequest request)
    {
        // Base
        draw = Integer.parseInt(request.getParameter("draw"));
        start = Integer.parseInt(request.getParameter("start"));
        length = Integer.parseInt(request.getParameter("length"));
        
        // Columns
        String data;
        int i = 0;
        do {
            data = request.getParameter("columns[" + i + "][data]");
            if (data != null) {
                DataTablesColumn c = new DataTablesColumn();
                c.setData(data);
                c.setName(request.getParameter("columns[" + i + "][name]"));
                c.setSearchable(Boolean.valueOf(request.getParameter("columns[" + i + "][searchable]")));
                c.setOrderable(Boolean.valueOf(request.getParameter("columns[" + i + "][orderable]")));
                String se = request.getParameter("columns[" + i + "][search][value]");
                // XXX: Search regex
                Boolean seRegex = Boolean.valueOf(request.getParameter("columns[" + i + "][search][regex]"));
                c.setSearch(se);
                columnsIndex.put(i, c);
                columns.put(data, c);
            }
            i ++;
        } while(data != null);
        
        // Order
        String column;
        i = 0;
        do {
            column = request.getParameter("order[" + i + "][column]");
            if (column != null) {
                DataTablesColumn dtc = columnsIndex.getOrDefault(Integer.parseInt(column), null);
                if (dtc != null) {
                    DataTablesOrder dto = new DataTablesOrder();
                    dto.setData(dtc.getName() != null && !dtc.getName().isEmpty() ? dtc.getName() : dtc.getData());
                    dto.setDir(request.getParameter("order[" + i + "][dir]").equals("asc") ? DataTablesOrder.ORDER_ASC : DataTablesOrder.ORDER_DESC);
                    order.add(dto);
                }
            }
            i ++;
        } while(column != null);
        
        // Search
        String se = request.getParameter("search[value]");
        // XXX: Search regex
        boolean seRegex = Boolean.valueOf(request.getParameter("search[regex]"));
        search = se;
    }
    /**
     * Return if a column has search or not.
     * @param name Column name.
     * @return true if it have, false otherwise.
     */
    public boolean hasColumnSearch(String name)
    {
        return (columns.containsKey(name) && 
                columns.get(name).getSearchable().equals(Boolean.TRUE) && 
                columns.get(name).getSearch() != null &&
                !columns.get(name).getSearch().isEmpty());
    }
    /**
     * Returns the search string from a column.
     * @param name Column name.
     * @return Search string or null.
     */
    public String getColumnSearch(String name)
    {
        if (hasColumnSearch(name)) {
            return columns.get(name).getSearch();
        }
        
        return null;
    }
    // ******************************************
    // GETTER & SETTER
    // ******************************************
    public Integer getDraw()
    {
        return draw;
    }
    public Integer getStart()
    {
        return start;
    }
    public Integer getLength()
    {
        return length;
    }
    public String getSearch()
    {
        return search;
    }
    public HashMap<String, DataTablesColumn> getColumns()
    {
        return columns;
    }
    public List<DataTablesOrder> getOrders()
    {
        return order;
    }
}