<#macro form>

    <div class="row">
        <div class="col s12">
            <div class="row">
                <div class="input-field col s12">
                    <input id="title" type="text" class="validate">
                    <label for="title">Title</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <input id="datepicker" type="text" class="datepicker">
                    <label for="datepicker">Datepicker</label>
                </div>
                <div class="input-field col s6">
                    <input id="timepicker" type="text" class="timepicker">
                    <label for="timepicker">Timepicker</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input id="description" type="text" class="validate">
                    <label for="description">Description</label>
                </div>
            </div>
        </div>
    </div>



    <script>
        $(document).ready(function(){
            $('.datepicker').datepicker();
            $('.timepicker').timepicker();
        });
    </script>
</#macro>