$(document).ready(function() {
    $(document).on('input', 'input:text', function()
    {
            $("button[name='btnConnex']").show(1000);
            $("button[name='btnConnex']").addClass(" animated shake");
    });
});