var commands = [];

$( document ).ready(function() {
    $('#command').focus();
    $('#commandForm').submit(function( event ) {

        $("#log-wrapper").hide();
        commands.push($('#command').val());
        event.preventDefault();
        $.ajax({
            url: "/command",
            data: {command: $('#command').val()},
        })
            .done(function( data ) {
                if ( console && console.log ) {
                    console.log( "Sample of data--:", data.slice( 0, 100 ) );
                }
                $("#gameInfo").html(data);
                $('#command').val("");
            });

            if($('#command').val() === 'commit suicide') {
                $("#log-wrapper").show();
                $("#log").html(commands.join("<br>"));
                commands = [];
            }
    });


    $('#log-delete').click(function( event ) {
        $("#log-wrapper").hide();
        $("#log").html("");
    });

});