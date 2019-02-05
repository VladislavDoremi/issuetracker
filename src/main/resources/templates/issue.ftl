<#import "macro/dependency.ftl" as dependency_container>
<#import "macro/navigation.ftl" as navigation_container>
<#import "macro/issue/form.ftl" as issue_form_container>

<!DOCTYPE html>
<html lang="en">

<#-- Import style dependency -->
<@dependency_container.header_dependency title="Issue" />

<body>
<#-- Import js dependency -->
<@dependency_container.body_dependency />

<#-- Import navigation -->
<@navigation_container.navigation/>

<div class="container">

    <div class="row">
        <#-- Import issue form -->
        <@issue_form_container.form/>
    </div>

    <#-- Create issue button -->
    <div class="fixed-action-btn">
        <a class="btn-floating btn-large waves-effect waves-light light-blue darken-2">
            <i class="material-icons">save</i>
        </a>
    </div>
</div>

</body>

</html>