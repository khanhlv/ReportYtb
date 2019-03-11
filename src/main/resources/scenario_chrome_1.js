setTimeout(function() {
    document.querySelector('.dropdown-trigger.style-scope.ytd-menu-renderer').click()
    console.log(1)
    setTimeout(function() {
        document.querySelector('iron-dropdown.style-scope.ytd-popup-container ytd-menu-service-item-renderer').click()
        console.log(2)
        setTimeout(function() {
            document.querySelector('paper-radio-button[name="6"]').click()
            console.log(3)
            setTimeout(function() {
                document.querySelector('paper-input-container input#input-5').click()
                console.log(4)
                setTimeout(function() {
                    document.querySelectorAll('paper-listbox.style-scope.yt-options-renderer')[4].querySelectorAll('paper-item')[2].click()
                    console.log(5)
                    setTimeout(function() {
                        document.querySelector('yt-report-form-modal-renderer.style-scope.ytd-popup-container yt-button-renderer#submit-button').click()
                        console.log(6)
                        setTimeout(function() {
                            //document.querySelector('input#input-8').value = "0"
                            //document.querySelector('input#input-9').value = "30"

                            //document.querySelector('input#input-8').setAttribute("value", "0")
                            //document.querySelector('input#input-9').setAttribute("value", "30")

                            document.querySelector('iron-autogrow-textarea').value = "Vi phạm cộng đồng"
                            console.log(7)
                            setTimeout(function() {
                                document.querySelector('#submit-button.style-scope.ytd-report-details-form-renderer').querySelector('ytd-button-renderer').click()
                                console.log(8)
                                // setTimeout(function() {
                                //     document.querySelector('.buttons.style-scope.yt-fancy-dismissible-dialog-renderer').querySelector('yt-button-renderer').click()
                                //     console.log(9)
                                // }, 3000);
                            }, 3000);
                        }, 3000);
                    }, 3000);
                }, 3000);
            }, 3000);
        }, 5000);
    }, 3000);
}, 3000);