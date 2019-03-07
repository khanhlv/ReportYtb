var data = new FormData();
data.append("session_token", document.querySelector('input[name="session_token"]').value);
data.append("video_id", ytplayer.config.args.video_id);
data.append("reason", "Z");
data.append("sub_reason", "21");
data.append("flag_t_mins", "0");
data.append("flag_t_secs", "50");
data.append("flag_desc", "Báo cáo vi phạm cộng đồng");

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;
xhr.addEventListener("readystatechange", function () {
    if (this.readyState === 4) {
        console.log(this.responseText);
    }
});

xhr.open("POST", "https://www.youtube.com/watch_actions_ajax?action_flag_video=1");
xhr.setRequestHeader("cache-control", "no-cache");

xhr.send(data);