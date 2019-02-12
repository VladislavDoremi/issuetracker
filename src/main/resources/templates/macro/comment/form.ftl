<#macro comment_form issue="${issue}">

    <div class="row">
    <div class="input-field col s12">
    <textarea id="comment-description-${issue.issueUuid}" type="text" class="materialize-textarea" data-length="500"></textarea>
    <label for="comment-description">Comment</label>
    <span class="helper-text" data-error="The field is not correct!"
          data-success="The field is correct.">Please describe the comment</span>
    </div>
    </div>

    <div class="row">
    <div class="col s12">
    <div class="col m3 s4 right">
    <a class="save-comment-btn waves-effect waves-light green darken-2 center-align btn col s12" data-issue-uuid="${issue.issueUuid}">
        <span class="hide-on-small-and-down"><i class="material-icons left">add</i>add</span>
        <span class="hide-on-med-and-up"><i class="material-icons center">add</i></span>
    </a>
    </div>

    <div class=" col m3 s4">
<a class="clear-comment-btn waves-effect waves-light yellow darken-2 center-align btn col s12"  data-issue-uuid="${issue.issueUuid}">
    <span class="hide-on-small-and-down"><i class="material-icons left">clear</i>clear</span>
    <span class="hide-on-med-and-up"><i class="material-icons center">clear</i></span>
    </a>
    </div>
    </div>
    </div>

</#macro>