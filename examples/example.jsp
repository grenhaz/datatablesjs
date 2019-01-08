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