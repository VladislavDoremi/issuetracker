<#macro delete id="${id}" title="${title}" message="${message}">
    <!-- Modal Structure -->
    <div id="${id}" class="modal">
        <div class="modal-content">
            <h4>${title}</h4>
            <p>${message}</p>
        </div>
        <div class="modal-footer">
            <a href="#!" class="modal-close waves-effect waves-red btn-flat">Disagree</a>
            <a href="#!" class="modal-close waves-effect waves-green btn-flat btn-agree">Agree</a>
        </div>
    </div>

    <script>
        $(document).ready(function(){
            $('.modal').modal();
        });
    </script>
</#macro>