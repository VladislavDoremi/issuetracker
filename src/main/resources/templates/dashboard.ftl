<#import "macro/dependency.ftl" as dependency_container>
<#import "macro/navigation.ftl" as navigation_container>
<#import "macro/search.ftl" as search_container>
<#import "macro/issue/list.ftl" as issue_list_container>

<!DOCTYPE html>
<html lang="en">

<#-- Import style dependency -->
<@dependency_container.header_dependency title="Dashboard" />

<body>
<#-- Import js dependency -->
<@dependency_container.body_dependency />

<#-- Import navigation -->
<@navigation_container.navigation/>

<div class="container">

    <div class="row">
        <#-- Import searchbar -->
        <@search_container.search_navigation/>
    </div>

    <div class="row">
        <#-- Import issue list -->
        <@issue_list_container.issue_list issueList=issueList/>
    </div>

    <#-- Create issue button -->
    <div class="fixed-action-btn">
        <a class="btn-floating btn-large waves-effect waves-light light-blue darken-2">
            <i class="material-icons">add</i>
        </a>
    </div>
</div>

</body>

</html>