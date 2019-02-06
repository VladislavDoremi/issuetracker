<#import "../../macro/dependency.ftl" as dependency_container>
<#import "../../macro/navigation.ftl" as navigation_container>
<#import "../../macro/issue/form.ftl" as issue_form_container>
<#import "../../macro/footer.ftl" as footer_container>

<!DOCTYPE html>
<html lang="en">

<#-- Import style dependency -->
<@dependency_container.header_dependency title="Issue" />

<body>
<#-- Import js dependency -->
<@dependency_container.body_dependency />

<header>
    <#-- Import navigation -->
    <@navigation_container.navigation/>
</header>

<main>
    <div class="container">

        <div class="row">
            <#-- Import issue form -->
            <@issue_form_container.form/>
        </div>

    </div>
</main>

<#-- Import footer -->
<@footer_container.footer/>

</body>
</html>