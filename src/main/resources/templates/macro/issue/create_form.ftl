<#macro form>

    <div class="row">
        <div class="col s12">
            <div class="card-panel">
                <div>
                    <div class="input-field col s12">
                        <input id="title" type="text" data-length="60">
                        <label for="title">Title</label>
                        <span class="helper-text" data-error="The field is not correct!"
                              data-success="The field is correct">Please enter issue title</span>
                    </div>
                </div>

                <div>
                    <div class="input-field col m4 s12">
                        <select>
                            <option value="1" selected>New</option>
                            <option value="2" >In progress</option>
                            <option value="3" >Done</option>
                            <option value="4" >Cancel</option>
                        </select>
                        <label>Status</label>
                    </div>
                    <div class="input-field col m4 s12">
                        <i class="material-icons prefix">event</i>
                        <input id="datepicker" type="text" class="datepicker">
                        <label for="datepicker">Date</label>
                    </div>
                    <div class="input-field col m4 s12">
                        <i class="material-icons prefix">schedule</i>
                        <input id="timepicker" type="text" class="timepicker">
                        <label for="timepicker">Time</label>
                    </div>
                </div>

                <div>
                    <div class="input-field col s12">
                        <textarea id="description" type="text" class="materialize-textarea"
                                  data-length="500"></textarea>
                        <label for="description">Description</label>
                        <span class="helper-text" data-error="The field is not correct!"
                              data-success="The field is correct.">Please describe the issue</span>
                    </div>
                </div>

                <div class="row">
                    <div class="col s12 divider"></div>
                </div>

                <div class="row">
                    <div class="col s12">
                        <div class="col m3 s4 right">
                            <a id="save-button" class="waves-effect waves-light green darken-2 center-align btn col s12">
                                <span class="hide-on-small-and-down"><i class="material-icons left">save</i>save</span>
                                <span class="hide-on-med-and-up"><i class="material-icons center">save</i></span>
                            </a>
                        </div>

                        <div class=" col m3 s4 right">
                            <a class="waves-effect waves-light red darken-2 center-align btn col s12"
                               href="${WebPath.getDASHBOARD()}">
                                <span class="hide-on-small-and-down"><i class="material-icons left">cancel</i>cancel</span>
                                <span class="hide-on-med-and-up"><i class="material-icons center">cancel</i></span>
                            </a>
                        </div>

                        <div class=" col m3 s4">
                            <a id="clear-button" class="waves-effect waves-light yellow darken-2 center-align btn col s12">
                                <span class="hide-on-small-and-down"><i class="material-icons left">clear</i>clear</span>
                                <span class="hide-on-med-and-up"><i class="material-icons center">clear</i></span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function(){
            $('input#title, textarea#description').characterCounter();

            $('.datepicker').datepicker();
            $('.timepicker').timepicker();
            $('select').formSelect();

            $( "#clear-button" ).click(function() {
                $("input, textarea").val("");
            });

            $( "#save-button" ).click(function() {
                var title = $("#title").val(),
                    description = $("#description").val(),
                    status = $( "select option:selected" ).val();

                $.ajax({
                    url: '${WebPath.getISSUE()}',
                    method: 'POST',
                    data: {
                        title: title,
                        description: description,
                        status: status
                    },
                    success: function(data) {}
                });

            });


        });
    </script>

</#macro>