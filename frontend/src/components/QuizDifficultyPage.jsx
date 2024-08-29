import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const QuizDifficulty = (props) => {
    const [selectedDifficulty, setSelectedDifficulty] = useState(null);
    const navigate = useNavigate();

    const handleDifficultyClick = (difficulty) => {
        setSelectedDifficulty(difficulty);
        // Navigate to Title page with selected difficulty as state
        navigate('/quiztitle', { state: { difficulty } });
    };

    return (
        
        <section id="quizType" className={`quizType__wrap ${props.element}`}>
            <div className='difficulty-container'> 
            <h2>{props.title}</h2>
            <h2 style={{marginTop: '30px', marginBottom: '30px', fontSize: '24px', textAlign: 'center'}}>난이도를 선택하세요 ! 🙌</h2>
            <div className="difficultybutton-grid">
                <button className="title-button" onClick={() => handleDifficultyClick('상')}>상</button>
                <button className="title-button" onClick={() => handleDifficultyClick('중')}>중</button>
                <button className="title-button" onClick={() => handleDifficultyClick('하')}>하</button>
            </div>
            </div>
        </section>
    );
};

export default QuizDifficulty;
