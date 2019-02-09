function visibilityItems(iconVisibility) {
    $( "li .collapsible-header" ).click(function() {
        if (iconVisibility) {
            $( this ).find(".visibility-icon").text("visibility").css('color', '#000000');
            $( "li .collapsible-header" ).not( this ).show( 300 );
            iconVisibility = false;
        } else {
            $( this ).find(".visibility-icon").text("visibility_off").css('color', '#1976d2');
            $( "li .collapsible-header" ).not( this ).hide( 300 );
            iconVisibility = true;
        }
    });
}