<#import "../macro/dependency.ftl" as dependency_container>
<#import "../macro/navigation.ftl" as navigation_container>
<#import "../macro/search.ftl" as search_container>
<#import "../macro/issue/list.ftl" as issue_list_container>
<#import "../macro/footer.ftl" as footer_container>

<!DOCTYPE html>
<html lang="en">

<#-- Import style dependency -->
<@dependency_container.header_dependency title="Dashboard" />

<body>
<#-- Import js dependency -->
<@dependency_container.body_dependency />

<header>
    <#-- Import navigation -->
    <@navigation_container.navigation/>

    <div id="search-container" class="container">

        <div class="row">
            <#-- Import searchbar -->
            <@search_container.search_navigation/>
        </div>
    </div>
</header>

<main>
    <div class="container">

        <div class="row">
            <#-- Import issue list -->
            <@issue_list_container.issue_list/>
        </div>

        <#-- Create issue button -->
        <div class="fixed-action-btn">
            <a href="${WebPath.getISSUE_FORM()}" class="btn-floating btn-large waves-effect waves-light light-blue darken-2">
                <i class="material-icons">add</i>
            </a>
        </div>
    </div>
</main>

<#-- Import footer -->
<@footer_container.footer/>

</body>
</html>