import Header from "./components/layout/header.tsx";
import './components/layout/layout.css';
import './App.css';
import HomePage from "./pages/home.tsx";
import Footer from "./components/layout/footer.tsx";

export const App = () => {
    return (
        <>
            <Header />
            <main className="main">
                <HomePage />
            </main>
            <Footer />
        </>
    )
}

export default App;