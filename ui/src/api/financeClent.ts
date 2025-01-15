export class FinanceClent {
    loadFinanceForUser = (userId: string) => {
        return fetch(`${import.meta.env.VITE_API_BASE_URL}/users/${userId}/finance`, {})
            .then(res => {
                if (res.ok) {
                    return res.json()
                }
                return null;
            });
    }
}

export default FinanceClent;