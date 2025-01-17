import {Card} from "./Card.tsx";
import {FinanceCardProps} from "../../types/finance.ts";


export const HeroCard = ({id, balance, interest_rate}: FinanceCardProps) => {
    return (
        <Card>
            <div id={`user-finance-${id}`} className="card--finance">
                <h2 className="card__title card__title--finance">Account number: {id}</h2>

                <p className="card__description card__description--finance">
                    Balance: {balance}
                </p>

                <p className="card__description card__description--finance">
                    Interest rate: {interest_rate}
                </p>
            </div>
        </Card>
    );
}

export default HeroCard;
