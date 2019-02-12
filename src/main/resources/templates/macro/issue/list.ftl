<#import "../modal/alert.ftl" as issue_delete_modal>
<#import "item.ftl" as issue_item>

<#macro issue_list>
    <ul class="collapsible popout">
    <#list issueList as item>
        <@issue_item.issue_item issue=item/>
    <#else>
        <div>No issue!</div>
    </#list>
    </ul>

    <@issue_delete_modal.alert id="comment-delete-modal" title="Delete comment" message="Are you sure you want to delete comment?"/>
    <@issue_delete_modal.alert id="issue-delete-modal" title="Delete issue" message="Are you sure you want to delete issue?"/>

    <script >
        $(document).ready(function(){
            $('.collapsible').collapsible();
            $('.dropdown-trigger').dropdown();
            $('select').formSelect();

            visibilityItems(false);

            $(".issue-delete-btn").click( function () {
                var issueUuid = $( this ).data("issue-uuid");

                $(".btn-agree").click( function () {
                    $.ajax({
                        url: '${WebPath.getISSUE()}?issueUuid=' + issueUuid,
                        method: 'DELETE',
                        success: function(data) {
                            location.reload();
                        }
                    });
                });
            });

            $( ".show-comment-btn" ).click(function() {
                var issueUuid = $( this ).data("issue-uuid");
                fetchComments(issueUuid);
            });

            $( ".save-comment-btn" ).click(function() {
                var issueUuid = $( this ).data("issue-uuid"),
                    description = $("#comment-description-" + issueUuid).val();

                description = validationString(description);

                $.ajax({
                    url: '${WebPath.getCOMMENT()}?issueUuid=' + issueUuid,
                    method: 'POST',
                    data: {
                        description: description
                    },
                    success: function(data) {
                        fetchComments(issueUuid);
                        clearComment(issueUuid);
                    }
                });
            });

            $( ".clear-comment-btn" ).click(function() {
                var issueUuid = $( this ).data("issue-uuid");
                clearComment(issueUuid);
            });

            $('select:not(.browser-default)').on('change', function (e) {
                var issueUuid = $( this ).data("issue-uuid");
                updateStatus(issueUuid, e.target.value);
            });

            function updateStatus(issueUuid, status) {

                var elem = $('#status-badge-' + issueUuid);

                $.ajax({
                    url: '${WebPath.getISSUE_UPDATE_STATUS()}?issueUuid=' + issueUuid,
                    method: 'PUT',
                    data: {
                        status: status
                    },
                    success: function(data) {
                        if (data === "1") {
                            elem.attr("data-badge-caption", "New").removeClass("orange green red").addClass("blue");
                        } else if (data === "2") {
                            elem.attr("data-badge-caption", "In progress").removeClass("blue green red").addClass("orange");
                        } else if (data === "3") {
                            elem.attr("data-badge-caption", "Done").removeClass("orange blue red").addClass("green");
                        } else if (data === "4") {
                            elem.attr("data-badge-caption", "Cancel").removeClass("orange green blue").addClass("red");
                        }
                    },
                    error: function () {
                        console.log("Error")
                    }
                });
            }

            function clearComment(issueUuid) {
                $("#comment-description-" + issueUuid).val("");
            }

            function fetchComments(issueUuid) {
                $("#comments-"+issueUuid).html("<div class=\"progress\">\n" +
                    "<div class=\"indeterminate\"></div></div>");

                $.ajax({
                    url: '${WebPath.getALL_COMMENTS()}?issueUuid=' + issueUuid,
                    method: 'GET',
                    data: {},
                    success: function(data) {
                        $("#comments-"+issueUuid).html(data);
                    },
                    error: function () {
                        console.log("Error")
                    }
                });
            }

        });
    </script>
</#macro>