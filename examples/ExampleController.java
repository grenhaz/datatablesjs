@Controller
public class GestorController
{
    @GetMapping("/worker/ajax")
    public @ResponseBody DataTablesResponse<Worker> actionGestoresTemporalAjax(HttpServletRequest request)
    {
        return getWorkers(new DataTablesRequest(request));
    }
    private DataTablesResponse<Worker> getWorkers(DataTablesRequest request)
    {
	DataTablesResponse<Worker> list = new DataTablesResponse<>();
	
	// Search workers by filters
	// Column filter
	if (request.hasColumnSearch(COLUMN_NAME)) {
            // req.getColumnSearch(COLUMN_NAME) => Filter
	}
	
	// Generic filter
	if (!request.getSearch().isEmpty()) {
            // req.getSearch() => Filter
	}
	
	// Order
	for (DataTablesOrder o: request.getOrders()) {
            // o.getData() => COLUMN_NAME
            // o.getDir()  => DataTablesOrder.ORDER_ASC or DataTablesOrder.ORDER_DESC
	}
	
	// Draw
	list.setDraw(request.getDraw());
	
	// Total records without filters
	list.setRecordsTotal(/* Total */);
	
	// Total records after applied filters
	list.setRecordsFiltered(/* Total filtered */);
	
	// List<Worker> of results
	list.setData(/* Records */);
	
	return list;
    }
}