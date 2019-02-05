<#import "../modal/alert.ftl" as delete_button>
<#import "item.ftl" as issue_item_container>

<#macro issue_list issueList="${issueList}">
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
        });
    </script>

    <@delete_button.delete id="delete-modal" href="#" title="Delete issue" message="Are you sure you want to delete issue?"/>

</#macro>