<#import "../modal/alert.ftl" as comment_delete_modal>
<#import "item.ftl" as comment_item>

<#macro comment_list>
<ul>
    <#list comments as item>
        <@comment_item.comment_item comment=item/>
    <#else>
        <div>No comments!</div>
    </#list>
</ul>

<#-- Initialization collapse -->
<script >
    $(document).ready(function(){
        $('.collapsible').collapsible();

        $(".delete-button").click( function () {
            var uuid = $( this ).data("issue-uuid");

            $(".btn-agree").click( function () {
                $.ajax({
                    url: '${WebPath.getCOMMENT()}?uuid=' + uuid,
                    method: 'DELETE',
                    success: function(data) {

                    }
                });
            });
        });
    });
</script>

    <@comment_delete_modal.alert id="comment-delete-modal" title="Delete comment" message="Are you sure you want to delete comment?"/>

</#macro>