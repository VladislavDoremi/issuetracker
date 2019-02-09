<#import "../macro/dependency.ftl" as dependency_container>
<#import "../macro/login/form.ftl" as login_form_container>
<#import "../macro/footer.ftl" as footer_container>

<!DOCTYPE html>
<html lang="en">

<#-- Import style dependency -->
<@dependency_container.header_dependency title="Login" />

<body>
<#-- Import js dependency -->
<@dependency_container.body_dependency />

<header>
    <nav class="blue darken-2">
        <div class="container">
            <div class="nav-wrapper">
                <a href="#" class="brand-logo"><i class="fas fa-columns hide-on-small-and-down"></i>ITracker</a>
            </div>
        </div>
    </nav>
</header>

<main>
    <div class="container" style="margin-top: 15vh;">

        <@login_form_container.form/>

    </div>
</main>

<footer class="page-footer blue darken-2">
    <div class="footer-copyright">
        <div class="container">
            © 2019 Copyright Vladislav DoReMi
        </div>
    </div>
</footer>

</body>
</html>