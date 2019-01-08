# datatablesjs
Java implementation to use DataTables JS

# Example

## Controller
```java
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
```

## JSP

```jsp
<table id="records" class="table table-striped table-bordered" cellspacing="0">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
    </thead>
</table>
<script>
    $(function() {
        $('#records').DataTable({
            "order": [[ 0, "asc" ]],
            "processing": true,
            "serverSide": true,
            "ajax": "<c:url value="/worker/ajax" />",
            "columns": [
                {
                    "data": "id"
                }, {
                    "data": "name"
                }
            ]
            });
        });
    });
</script>
```
