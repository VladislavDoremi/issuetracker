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
                    <div class="input-field col m4 s12">
                        <select id="issue-status">
                            <option value="1" <#if issue.status = 1>selected</#if>>New</option>
                            <option value="2" <#if issue.status = 2>selected</#if>>In progress</option>
                            <option value="3" <#if issue.status = 3>selected</#if>>Done</option>
                            <option value="4" <#if issue.status = 4>selected</#if>>Cancel</option>
                        </select>
                        <label>Status</label>
                    </div>
                    <div class="input-field col m4 s12">
                        <i class="material-icons prefix">event</i>
                        <input id="issue-datepicker" type="text" class="datepicker">
                        <label for="issue-datepicker">Date</label>
                    </div>
                    <div class="input-field col m4 s12">
                        <i class="material-icons prefix">schedule</i>
                        <input id="issue-timepicker" type="text" class="timepicker">
                        <label for="issue-timepicker">Time</label>
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

            $('.datepicker').datepicker();
            $('.timepicker').timepicker();
            $('select').formSelect();

            $( "#clear-issue-btn" ).click(function() {
                $("input, textarea").val("");
            });

            $( "#save-issue-btn" ).click(function() {
                var issueUuid = "${issue.issueUuid}",
                    title = $("#issue-title").val(),
                    description = $("#issue-description").val(),
                    status = $( "#issue-status option:selected" ).val();

                $.ajax({
                    url: '${WebPath.getISSUE()}?issueUuid=' + issueUuid,
                    method: 'PUT',
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