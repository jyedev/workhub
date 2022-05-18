<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

var socket = null;
$(document).ready(function(){
	
	sock = new SockJS('/alert');
	
	sock.onopen = function() {
		console.log('open');
	};
	
	sock.onmessage = onMessage;
	
});

function onMessage(evt) {
	var data = evt.data;
	
	const Toast = Sql.mixin({
		toast: true,
		position: 'top-middle',
		showConfirmButton: false,
		timer: 3000,
		timerProgressBar: true,
		didOpen: (toast) => {
			toast.addEventListener('mouseenter', Swal.stopTimer);
			toast.addEventListener('mouseleave', Swal.resumeTimer);
		}
	})
	
	Toast.fire({
		icon: 'warning',
		html: 'data',
	})
	
		
}
