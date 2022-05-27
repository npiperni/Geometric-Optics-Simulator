# Vanier GUI-Project Geometric Optics Simulator
## Outline

<ol>
    <li>Program Description</li>
    <ul>
        <li>Concept Description</li>
        <li>Implementation Descriptions</li>
    </ul>
    <li>Program Features</li>
    <li>Team Responsibilities</li>
    <li>Challenges</li>
    <li>Learning Outcomes</li>
</ol>
<h2>Program Description</h2>
<hr>


    
<h4>Concept</h4>

<table>
    <tr>
       <td>
        <ul>
            <li>Optical geometry : An abstract concept of determining the path of light rays.</li>
            <li>In our case optical geometry is mixed with optics (from physics), to approximate the position and dimensions of the final image.</li>
        </ul>
       </td> 
       <td>
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/Lens3b.svg/360px-Lens3b.svg.png" alt="geometry optics">
       </td>
    </tr>
</table>

<h4>Implementations</h4>

<ol>
    <li>The program reads values imputed by the user.</li>
    <li>The program calculates the resulting values (h<sub>i</sub>, h<sub>o</sub>, M).</li>
    <li>The program then creates the animations that it animated depending 
        on the location and height of the image, found through the calculations.</li>
</ol>

<h5><em><u>Formulas used in calculations</u></em></h5>

<p>
    1/f = 1/d<sub>i</sub> + 1/d<sub>o</sub>, M = h<sub>i</sub>/h<sub>o</sub> = -d<sub>i</sub>/d<sub>o</sub>
    <ul>
        <pre>
f = focal length
M = magnification
h<sub>i</sub> = image height 
h<sub>o</sub> = image height
d<sub>i</sub> = object distance
d<sub>o</sub> = object height
        </pre>
    </ul>

    <h5><i>Pythagorean theorem : a2 + b2 = c2 ; was also used to calculate the ray lengths and trigonometry was used to calculate the ray angles in the animation.</i></h5>
</p>



