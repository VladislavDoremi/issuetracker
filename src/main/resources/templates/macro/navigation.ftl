<#macro navigation>
    <nav class="row z-depth-4 blue darken-2 navbar-fixed">
        <div class="container">
            <div class="nav-wrapper">
                <a href="/dashboard" class="brand-logo"><i class="fas fa-columns hide-on-small-and-down"></i>ITracker</a>
                <a href="#" data-target="mobile-menu" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <@link_list/>
                </ul>
            </div>
        </div>
    </nav>

    <ul class="sidenav" id="mobile-menu">
        <@link_list/>
    </ul>

    <script>
        $(document).ready(function(){
            $('.sidenav').sidenav();
        });
    </script>
</#macro>

<#macro link_list>
    <li><a href="${WebPath.getDASHBOARD()}"><i class="fas fa-columns medium-icon"></i> Dashboard</a></li>
    <li><a href="${WebPath.getABOUT_ME()}"><i class="fas fa-info-circle medium-icon"></i> About Me</a></li>

    <#if currentUser??>
        <li>
            <form id="logout-form" method="post" action="${WebPath.getLOGOUT()}">
                <a href="#" onclick="document.getElementById('logout-form').submit()"><i class="fas fa-sign-out-alt medium-icon"></i> Sign Out</a>
            </form>
        </li>
    <#else>
        <li><a href="${WebPath.getLOGIN()}"><i class="fas fa-sign-in-alt medium-icon"></i> Sign In</a></li>
    </#if>

</#macro>