import axios from 'axios'
import icon from '../../../assets/img/notification-icon.svg'
import { BASE_URL } from '../../../utils/request'
import './style.css'

type Props = {
	saleID: number
}

function handleClick(id: number) {
	axios(`${BASE_URL}/${id}/notification`).then((res) => {
		console.log(res.status)
	})
}

function NotificationButton({ saleID }: Props) {
	return (
		<div className="dsmeta-red-btn" onClick={() => handleClick(saleID)}>
			<img src={icon} alt="Notificar" />
		</div>
	)
}

export default NotificationButton
