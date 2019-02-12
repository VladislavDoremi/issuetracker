<#macro form>

    <div class="row">
        <div class="col s12">
            <div class="card-panel">
                <div>
                    <div class="input-field col s12">
                        <input id="issue-title" type="text" data-length="60" value="${issue.title}">
                        <label for="issue-title">Title</label>
                        <span class="helper-text" data-error="The field is not correct!"
                              data-success="The field is correct">Please enter issue title</span>
                    </div>
                </div>

                <div>
                    <div class="input-field col m6 s12">
                        <i class="material-icons prefix">event</i>
                        <input id="start-datepicker" type="text" class="datepicker" value="${issue.startDate}">
                        <label for="start-datepicker">Start date</label>
                    </div>
                    <div class="input-field col m6 s12">
                        <i class="material-icons prefix">event</i>
                        <input id="deadline-datepicker" type="text" class="datepicker" value="${issue.deadlineDate}">
                        <label for="deadline-datepicker">Deadline</label>
                    </div>
                </div>

                <div>
                    <div class="input-field col s12">
                        <textarea id="issue-description" type="text" class="materialize-textarea"
                                  data-length="500">${issue.description}</textarea>
                        <label for="issue-description">Description</label>
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
                            <a id="save-issue-btn" class="waves-effect waves-light green darken-2 center-align btn col s12">
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
                            <a id="clear-issue-btn" class="waves-effect waves-light yellow darken-2 center-align btn col s12">
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

            /* Инициализация datapicker*/
            M.Datepicker.init($('.datepicker').datepicker(), {
                format: 'dd/mm/yyyy'
            });

            //$('select').formSelect();

            $( "#clear-issue-btn" ).click(function() {
                $("input#issue-title, textarea#issue-description").val("");
            });

            $( "#save-issue-btn" ).click(function() {
                var issueUuid = "${issue.issueUuid}",
                    status = "${issue.status}",//$( "#issue-status option:selected" ).val(),
                    title = $("#issue-title").val(),
                    description = $("#issue-description").val(),
                    startDate = $("#start-datepicker").val(),
                    deadlineDate = $("#deadline-datepicker").val()


                $.ajax({
                    url: '${WebPath.getISSUE()}?issueUuid=' + issueUuid,
                    method: 'PUT',
                    data: {
                        status: status,
                        title: title,
                        description: description,
                        startDate: startDate,
                        deadlineDate: deadlineDate
                    },
                    success: function(data) {
                        location.href = ${WebPath.getDASHBOARD()};
                    }
                });

            });


        });
    </script>

</#macro>