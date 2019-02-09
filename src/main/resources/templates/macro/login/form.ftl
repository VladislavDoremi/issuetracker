<#macro form>

    <div class="row">
        <div class="col offset-l3 l6 s12">
            <div class="card-panel">
                <form id="login-form" method="post">

                    <#if authenticationFailed??>
                        <p>Failed</p>
                    <#elseif authenticationSucceeded??>
                        <p>Succes</p>
                    <#elseif loggedOut??>
                        <p>Out</p>
                    </#if>

                    <div>
                        <div class="input-field col s12">
                            <input name="username" id="username" type="text" data-length="60" value="doremi" required>
                            <label for="username">Login</label>
                            <span class="helper-text" data-error="The field is not correct!"
                                  data-success="The field is correct">Please enter user login</span>
                        </div>
                    </div>

                    <div>
                        <div class="input-field col s12">
                            <input name="password" id="password" type="password" data-length="60" value="password" required>
                            <label for="password">Password</label>
                            <span class="helper-text" data-error="The field is not correct!"
                                  data-success="The field is correct.">Please enter password</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col s12 divider"></div>
                    </div>

                    <div class="row">
                        <button type="submit" class="waves-effect waves-light blue darken-2 center-align btn col s12">login</button>
                    </div>

                    <#if loginRedirect??>
                        <input type="hidden" name="loginRedirect" value="${loginRedirect}">
                    </#if>

                </form>
            </div>
        </div>
    </div>

</#macro>