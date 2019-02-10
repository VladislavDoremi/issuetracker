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

                $.ajax({
                    url: '${WebPath.getALL_COMMENTS()}?issueUuid=' + issueUuid,
                    method: 'GET',
                    data: {},
                    success: function(data) {
                        $("#comments-"+issueUuid).html(data);
                    }
                });
            });

            $( ".save-comment-btn" ).click(function() {
                var issueUuid = $( this ).data("issue-uuid"),
                    description = $("#comment-description-" + issueUuid).val();

                $.ajax({
                    url: '${WebPath.getCOMMENT()}?issueUuid=' + issueUuid,
                    method: 'POST',
                    data: {
                        description: description
                    },
                    success: function(data) {}
                });
            });

            $( ".clear-comment-btn" ).click(function() {
                var issueUuid = $( this ).data("issue-uuid");
                $("#comment-description-" + issueUuid).val("");
            });

        });
    </script>

</#macro>