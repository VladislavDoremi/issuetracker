<#import "../modal/alert.ftl" as delete_button>
<#import "item.ftl" as issue_item_container>

<#macro issue_list>
    <ul class="collapsible popout">
    <#list issueList as item>
        <@issue_item_container.issue_item issue=item/>
    <#else>
        <div>No issue!</div>
    </#list>
    </ul>

    <#-- Initialization collapse -->
    <script >
        $(document).ready(function(){
            $('.collapsible').collapsible();

            $(".delete-button").click( function () {
                var uuid = $( this ).data("uuid");

                $(".btn-agree").click( function () {
                    $.ajax({
                        url: '${WebPath.getISSUE()}?uuid=' + uuid,
                        method: 'DELETE',
                        success: function(data) {
                            location.reload();
                        }
                    });
                });
            });
        });
    </script>

    <@delete_button.delete id="delete-modal" title="Delete issue" message="Are you sure you want to delete issue?"/>

</#macro>