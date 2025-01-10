import {HeroCard} from "../components/cards/hero-card.tsx";
import './home.css';

export const HomePage = () => {
    return (
        <div className="home">
            <HeroCard userName={'Test'} />
        </div>
    )
}

export default HomePage;