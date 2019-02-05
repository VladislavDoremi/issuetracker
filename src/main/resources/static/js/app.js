function visibilityIcon(iconVisibility) {
    $( "li .collapsible-header" ).click(function() {
        if (iconVisibility) {
            $( this ).find(".visibility-icon").text("visibility").css('color', '#000000');
            iconVisibility = false;
        } else {
            $( this ).find(".visibility-icon").text("visibility_off").css('color', '#1976d2');
            iconVisibility = true;
        }
    });
}

function hideItems(itemVisibility) {
    $( "li .collapsible-header" ).click(function() {
        if (itemVisibility) {
            $( "li .collapsible-header" ).not( this ).hide( 300 );
            itemVisibility = false;
        } else {
            $( "li .collapsible-header" ).not( this ).show( 300 );
            itemVisibility = true;
        }
    });
}